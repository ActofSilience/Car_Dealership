package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.dev.hagan.models.Car;
import com.dev.hagan.models.Offer;
import com.dev.hagan.models.Owned;
import com.dev.hagan.models.User;
import com.dev.hagan.service.CarService;
import com.dev.hagan.service.OfferService;
import com.dev.hagan.service.OwnedService;
import com.dev.hagan.service.UserService;

/**
 * 
 */

/**
 * @author actof
 *
 */

public class MethodTester {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testAddDeleteCar() {
		Car car = new Car();
		car.setCarBrand("Ford");
		car.setCarId(400);
		car.setCarModel("Exploder");
		car.setMileage(0);
		car.setYear(2019);
		car.setPrice(40000);
		assertTrue(CarService.addCar(car));
		assertTrue(CarService.deleteCar(294));
	}

	@Test
	void testGetAllCars() {
		CarService.getAllCars();

	}

	@Test
	void testGetCar() {
		Car car = CarService.getCar(85);
		

		assertEquals(CarService.getCar(85).toString(), car.toString());

	}

	@Test
	void testAddOffer() {
		Offer offer = new Offer();
		offer.setCarId(85);
		offer.setDownPayment(0);
		offer.setUsername("Will");
		

		assertTrue(OfferService.addOffer(offer));
	}

	@Test
	void testUpdateOfferApprove() {
		Offer offer = new Offer();

		assertTrue(OfferService.updateOfferApprove(offer));

	}

	@Test
	void testUpdateOfferReject() {
		Offer offer = new Offer();

		assertTrue(OfferService.updateOfferReject(offer));

	}

	@Test
	void testGetOffer() {
		OfferService.getOffer(236);
		Offer offer = new Offer();
		offer.setOfferId(236);
		offer.setCarId(145);
		offer.setUsername("Larry");
		offer.setStatus("Rejected");
		offer.setDownPayment(2000);
		assertEquals(OfferService.getOffer(236).toString(), offer.toString());

	}

	@Test
	void testGetAllOffers() {
		List<Offer> offers = new ArrayList<Offer>();

		OfferService.getAllOffers();
		assertEquals(offers.toString(), OfferService.getAllOffers().toString());

	}

	@Test
	void testGetUser() {
		User user = UserService.getUser("Stuart");
		assertEquals("Stuart", user.getUsername());
	}

	@Test
	void testAddDeleteUser() {
		User user = new User();
		user.setUsername("Rube");
		user.setPassword("0000");
		user.setIsEmployee(0);
		assertTrue(UserService.addUser(user));
		assertTrue(UserService.deleteUser("Rube"));
	}

	@Test
	void testDeleteUser() {

		assertTrue(UserService.deleteUser("Bob"));

	}

	@Test
	void testGetUsername() {
		User user = UserService.getUsername("Stuart");

		assertEquals("Stuart", user.getUsername());

	}

	@Test
	void testGetUsersOffers() {
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(new Offer());
		Offer offer = new Offer(); 
		offer.setOfferId(0);
		offer.setCarId(0);
		offer.setDownPayment(0);
		offer.setStatus(null);
		offer.setUsername(null);

		offers.add(offer); 
		
		

		assertTrue(true);
	}

	

	@Test
	void testGetOwned() {
		Owned own = new Owned(); 
		own.setCarId(85);
		own.setUsername("Stuart");
		own.setBalance(0);
		own.setMonthlyrate(0);
		own.setMonthsremaining(48);
		own.setDownpayment(2000);
		
		assertEquals( own.toString() ,OwnedService.getOwned("Stuart").toString());
	}

	
	}
