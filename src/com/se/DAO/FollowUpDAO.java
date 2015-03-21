/**
 * 
 */
package com.se.DAO;

import java.util.List;
import com.se.mapping.Followup;

public interface FollowUpDAO extends GenericDAO<Followup, Integer> {

	List<Followup> findByFollowId(int id);

	List<Followup> findByVisitId(int id);

}
