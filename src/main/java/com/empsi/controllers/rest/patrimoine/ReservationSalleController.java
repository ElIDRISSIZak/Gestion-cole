package com.empsi.controllers.rest.patrimoine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.patrimoine.ReservationSalle;

import com.empsi.managers.patrimoine.ReservationSalleMetierImpl;

@RestController
@RequestMapping("/ReservationSalle")
public class ReservationSalleController {
	
	@Autowired
	ReservationSalleMetierImpl reservationSalleMetierImpl;
	

	/**
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/saveReservationSalle", method = RequestMethod.POST)
	public ResponseEntity<ReservationSalle> addReservationSalle(@RequestBody ReservationSalle reservationSalle) {
		reservationSalleMetierImpl.save(reservationSalle);
		return new ResponseEntity<ReservationSalle>(reservationSalle, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOneReservationSalle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationSalle> getReservationSalle(@PathVariable("id") Long id) {
		ReservationSalle reservationSalle = reservationSalleMetierImpl.get(id);
		if (reservationSalle == null) {
			return new ResponseEntity<ReservationSalle>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ReservationSalle>(reservationSalle, HttpStatus.OK);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ReservationSalles", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationSalle>> getAllReservationSalles() {
		List<ReservationSalle> reservationSalles = reservationSalleMetierImpl.getAll();
		if (reservationSalles.isEmpty()) {
			return new ResponseEntity<List<ReservationSalle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReservationSalle>>(reservationSalles, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteReservationSalle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ReservationSalle> deleteSalle(@PathVariable("id") Long id) {
		ReservationSalle reservationSalle = reservationSalleMetierImpl.get(id);
		if (reservationSalle == null) {
			return new ResponseEntity<ReservationSalle>(HttpStatus.NOT_FOUND);
		}
		reservationSalleMetierImpl.delete(id);
		return new ResponseEntity<ReservationSalle>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/updateReservationSalle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ReservationSalle> updateSalle(@PathVariable("id") Long id, @RequestBody ReservationSalle reservationSalle) {
		reservationSalleMetierImpl.Update(reservationSalle);
		return new ResponseEntity<ReservationSalle>(HttpStatus.OK);
	}
	

}
