package com.dev.hagan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;

import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.Offer;
import com.dev.hagan.models.Owned;
import com.dev.hagan.util.DBConnect;

public class OfferDAOImpl implements OfferDAO {
	Connection conn = DBConnect.getConnection();

	public Offer getOffer(int offerId) {

		try {

			String sql = "SELECT * FROM cardealership_offers WHERE offer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, offerId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Offer o = new Offer();
				o.setOfferId(rs.getInt("OFFER_ID"));
				o.setCarId(rs.getInt("CAR_ID"));
				o.setUsername(rs.getString("USERNAME"));
				o.setStatus(rs.getString("STATUS"));
				o.setDownPayment(rs.getInt("DOWNPAYMENT"));
	
				
				return o;

			}

		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return null;

	}

	public List<Offer> getAllOffers() {
		try {

			String sql = "SELECT * FROM cardealership_offers";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Offer> offers = new ArrayList<Offer>();

			while (rs.next()) {

				offers.add(new Offer(rs.getInt("OFFER_ID"), rs.getInt("CAR_ID"), rs.getString("USERNAME"),
						rs.getString("STATUS"), rs.getInt("DOWNPAYMENT")));

			}

			return offers;

		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return null;
	}

	public boolean addOffer(Offer offerId) {
		try {

			String sql = "CALL add_offer(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, offerId.getOfferId());
			cs.setInt(2, offerId.getCarId());
			cs.setString(3, offerId.getUsername());
			cs.setInt(4, offerId.getDownPayment());
			cs.setString(5, offerId.getStatus());
			
			
			cs.execute();
			return true;

		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateOfferApprove(Offer offer) {
		try {
			String sql = "UPDATE CARDEALERSHIP_OFFERS SET STATUS = 'Approved' WHERE OFFER_ID = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, offer.getOfferId());
			ps.executeQuery();

			return true; 
		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return false;

	}

	public List<Offer> getUserOffers(String username) {
		try {

			String sql = "SELECT * FROM CARDEALERSHIP_OFFERS WHERE USERNAME = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			List<Offer> offers = new ArrayList<Offer>();
			while (rs.next()) {

				offers.add(new Offer(rs.getInt("OFFER_ID"), rs.getInt("CAR_ID"), rs.getString("USERNAME"),
						rs.getString("STATUS"), rs.getInt("DOWNPAYMENT")));

			}
			return offers;
		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateOfferReject(Offer offer) {
		try {
			String sql2 = "UPDATE CARDEALERSHIP_OFFERS SET STATUS = 'Rejected' WHERE OFFER_ID <> ?  AND CAR_ID = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1, offer.getOfferId());
			ps1.setInt(2,  offer.getCarId());
			ps1.executeQuery();

			return true;
		} catch (SQLException e) {
			JLogger.logger.warn("Exception caught");
			e.printStackTrace();
		}

		return false;
	}




}