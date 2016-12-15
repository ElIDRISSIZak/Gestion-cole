package com.empsi.services.patrimoine;

import java.util.List;

import com.empsi.entities.patrimoine.ReservationSalle;


public interface IReservationSalleMetier{
	public ReservationSalle save(ReservationSalle reservationSalle);
	public ReservationSalle get(Long id);
	public ReservationSalle Update(ReservationSalle reservationSalle );
	public List<ReservationSalle> getAll();
	public Boolean delete(Long id);
}
