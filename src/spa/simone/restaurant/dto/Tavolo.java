/*
 * This file is part of Restaurant project.
 * 
 * Restaurant is a java project for the second assignment of Enterprise Application. 
 * Copyright (C) 2011 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spa.simone.restaurant.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "tavolo")
public final class Tavolo implements Serializable {

   private static final long serialVersionUID = -4958224868601098241L;
   private Long id;
   private Integer numeroPosti;
   private Integer numeroTavolo;
   private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
   private Set<Ordinazione> ordinazioni = new HashSet<Ordinazione>();

   public Tavolo() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Column(name = "numero_posti", length = 3, nullable = false)
   public Integer getNumeroPosti() {
      return numeroPosti;
   }

   @Column(name = "numero_tavolo", length = 3, nullable = false, unique = true)
   public Integer getNumeroTavolo() {
      return numeroTavolo;
   }

   @ManyToMany(mappedBy = "tavoli")
   public Set<Prenotazione> getPrenotazioni() {
      return prenotazioni;
   }

   @OneToMany(mappedBy = "tavolo")
   public Set<Ordinazione> getOrdinazioni() {
      return ordinazioni;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setNumeroPosti(Integer numeroPosti) {
      this.numeroPosti = numeroPosti;
   }

   public void setNumeroTavolo(Integer numeroTavolo) {
      this.numeroTavolo = numeroTavolo;
   }

   protected void setPrenotazioni(Set<Prenotazione> prenotazioni) {
      this.prenotazioni = prenotazioni;
   }

   public boolean addPrenotazione(Prenotazione prenotazione) {
      return this.prenotazioni.add(prenotazione);
   }

   public boolean removePrenotazione(Prenotazione prenotazione) {
      return this.prenotazioni.remove(prenotazione);
   }

   protected void setOrdinazioni(Set<Ordinazione> ordinazioni) {
      this.ordinazioni = ordinazioni;
   }

   public boolean addOrdinazione(Ordinazione ordinazione) {
      return this.ordinazioni.add(ordinazione);
   }

   public boolean removeOrdinazione(Ordinazione ordinazione) {
      return this.ordinazioni.remove(ordinazione);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((numeroPosti == null) ? 0 : numeroPosti.hashCode());
      result = prime * result + ((numeroTavolo == null) ? 0 : numeroTavolo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Tavolo other = (Tavolo) obj;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (numeroPosti == null) {
	 if (other.numeroPosti != null) return false;
      } else if (!numeroPosti.equals(other.numeroPosti)) return false;
      if (numeroTavolo == null) {
	 if (other.numeroTavolo != null) return false;
      } else if (!numeroTavolo.equals(other.numeroTavolo)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Tavolo [id=");
      builder.append(id);
      builder.append(", numeroPosti=");
      builder.append(numeroPosti);
      builder.append(", numeroTavolo=");
      builder.append(numeroTavolo);
      builder.append("]");
      return builder.toString();
   }

}
