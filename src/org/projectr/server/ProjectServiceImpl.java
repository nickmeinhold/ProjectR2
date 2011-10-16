package org.projectr.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.projectr.client.ProjectService;
import org.projectr.shared.ProjectDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ProjectServiceImpl extends RemoteServiceServlet implements ProjectService {

	public ProjectDTO createProject(ProjectDTO dto) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query query = pm.newQuery(KeywordDAO.class, "value == :val");
		query.setUnique(true);
		
		ProjectDAO dao = new ProjectDAO(dto);
		
		for(String keywordStr : dto.getKeywords()) {
			KeywordDAO keywordDAO = (KeywordDAO) query.execute(keywordStr);
			if(keywordDAO == null) {
				keywordDAO = new KeywordDAO(keywordStr);
				pm.makePersistent(keywordDAO);
			}
			dao.addKeyWordId(keywordDAO.getId());
		}
		
		pm.makePersistent(dao);
		
		ProjectDTO returnDTO = dao.toDTO();
		
		for(String keywordId : dao.getKeywordIds()) {
			returnDTO.addKeyword(pm.getObjectById(KeywordDAO.class, keywordId).getValue());
		}
		
		pm.close();
		
		return returnDTO;
		
	}

	public List<String> retrieveKeywords() {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Extent<KeywordDAO> extent = pm.getExtent(KeywordDAO.class, false);
		
		List<String> keywords = new ArrayList<String>();
		for(KeywordDAO dao : extent) {
			keywords.add(dao.getValue());
		}
		
		extent.closeAll();
		pm.close();
		
		return keywords;
		
	}

	

}
