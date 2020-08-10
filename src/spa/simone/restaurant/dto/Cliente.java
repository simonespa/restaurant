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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente implements Serializable {

   private static final long serialVersionUID = 5490848939452528486L;
   private Long id;
   private String tipo;
   private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
   private Set<Ordinazione> ordinazioni = new HashSet<Ordinazione>();

   public Cliente() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Column(nullable = false)
   public String getTipo() {
      return tipo;
   }

   @OneToMany(mappedBy = "cliente")
   public Set<Prenotazione> getPrenotazioni() {
      return prenotazioni;
   }

   @OneToMany(mappedBy = "cliente")
   public Set<Ordinazione> getOrdinazioni() {
      return ordinazioni;
   }

   public void setId(Long id) {
      this.id = id;
   }

   protected void setTipo(String tipo) {
      this.tipo = tipo;
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
      result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (!(obj instanceof Cliente)) return false;
      Cliente other = (Cliente) obj;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (tipo == null) {
	 if (other.tipo != null) return false;
      } else if (!tipo.equals(other.tipo)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Cliente [id=");
      builder.append(id);
      builder.append(", tipo=");
      builder.append(tipo);
      builder.append("]");
      return builder.toString();
   }

}
