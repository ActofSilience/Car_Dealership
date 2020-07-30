package com.dev.hagan.service;

import java.util.List;

import com.dev.hagan.dao.OfferDAO;
import com.dev.hagan.dao.OfferDAOImpl;
import com.dev.hagan.models.Offer;

public class OfferService {
	public static OfferDAO of = new OfferDAOImpl();

	public static Offer getOffer(int offerId) {
		return of.getOffer(offerId);
	}

	public static List<Offer> getAllOffers() {
		return of.getAllOffers();
	}

	public static boolean updateOfferApprove(Offer offer) {
		return of.updateOfferApprove(offer);
	}

	public static boolean addOffer(Offer offerId) {
		return of.addOffer(offerId);
	}

	public static List<Offer> getUserOffers(String username) {
		return of.getUserOffers(username);
	}

	public static boolean updateOfferReject(Offer offer) {
		return of.updateOfferReject(offer);
	}
	
}