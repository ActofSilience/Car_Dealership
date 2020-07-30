package com.dev.hagan.dao;

import java.util.List;

import com.dev.hagan.models.Offer;


public interface OfferDAO {

	public Offer getOffer(int offerId);

	public List<Offer> getAllOffers();

	public List<Offer> getUserOffers(String username);
	
	public boolean addOffer(Offer offerId);

	public boolean updateOfferApprove(Offer offer);
	
	public boolean updateOfferReject(Offer offer); 
	

	
}