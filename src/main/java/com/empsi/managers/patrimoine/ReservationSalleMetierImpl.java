package com.empsi.managers.patrimoine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.patrimoine.ReservationSalleRepository;
import com.empsi.entities.patrimoine.ReservationSalle;
import com.empsi.services.patrimoine.IReservationSalleMetier;

@Service
public class ReservationSalleMetierImpl implements IReservationSalleMetier {

	@Autowired
	ReservationSalleRepository reservationSalleRepository;
	
	@Override
	public ReservationSalle save(ReservationSalle reservationSalle) {
		reservationSalleRepository.save(reservationSalle);
		return reservationSalle;
	}

	@Override
	public ReservationSalle get(Long id) {
		ReservationSalle reservationSalle = reservationSalleRepository.findOne(id);
		return reservationSalle;
	}

	@Override
	public ReservationSalle Update(ReservationSalle reservationSalle) {
		reservationSalleRepository.saveAndFlush(reservationSalle);
		return reservationSalle;
	}

	@Override
	public List<ReservationSalle> getAll() {
		List< ReservationSalle> reservationSalles = reservationSalleRepository.findAll();
		return reservationSalles;
	}

	@Override
	public Boolean delete(Long id) {
		reservationSalleRepository.delete(id);
		return true;
	}

}
