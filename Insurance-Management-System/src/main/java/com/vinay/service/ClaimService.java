package com.vinay.service;

import java.util.List;

import com.vinay.model.Claim;

public interface ClaimService {
	
	/**
	 * 
	 * @param claim: take all about claim detail
	 * @return: return a saved claim in database
	 */
	Claim createNewClaim(Integer policyId,Claim claim);
	
	/**
	 * 
	 * @param claimId: take claim id by user and check this id exist in database or not
	 * if not exist in database then throw a particular exception 
	 * if exit in database then fetch and store a particular variable
	 * @return: return a this store claim detail in this variable.
	 */
	Claim getClaimById(Integer claimId);
	
	/**
	 * 
	 * @param claim: take all about claim detail
	 * @param claimId: take claim id by user and check this id exist in database or not
	 * if not exist in database then throw a particular exception 
	 * if exit in database then fetch and store a particular variable
	 * 
	 * after all opration swap all claim parameter data in featch claim data. after save in database 
	 * @return :return this save info in database
	 */
	Claim updateClaim(Claim claim, Integer claimId);
	
	/**
	 * 
	 * @param claimId: take claim id by user and check this id exist in database or not
	 * if not exist in database then throw a particular exception 
	 * if exit in database then fetch and store a particular variable
	 * after this delete all info in database
	 * @return:return a msg like claim data delete successfully...
	 */
	String deleteClaim(Integer claimId);
	
	/**
	 * 
	 * @return: this return all about claims data in who's store in database..
	 */
	List<Claim> getAllClaim();

}
