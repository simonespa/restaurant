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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "prenotazione")
public final class Prenotazione implements Serializable {

   private static final long serialVersionUID = 5489391699660769677L;
   private Long id;
   private Date dataOra;
   private Cliente cliente;
   private Set<Tavolo> tavoli = new HashSet<Tavolo>();

   public Prenotazione() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "data_ora", nullable = false)
   public Date getDataOra() {
      return dataOra;
   }

   @ManyToOne
   @JoinColumn(name = "id_cliente", nullable = false)
   @ForeignKey(name = "FK_PRENOTAZIONE_CLIENTE")
   public Cliente getCliente() {
      return cliente;
   }

   @ManyToMany
   @JoinTable(name = "prenotazione_tavolo", joinColumns = @JoinColumn(name = "id_prenotazione"), inverseJoinColumns = @JoinColumn(name = "id_tavolo"))
   @ForeignKey(name = "FK_PRENOTAZIONE-TAVOLO_PRENOTAZIONE", inverseName = "FK_PRENOTAZIONE-TAVOLO_TAVOLO")
   public Set<Tavolo> getTavoli() {
      return tavoli;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setDataOra(Date dataOra) {
      this.dataOra = dataOra;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   protected void setTavoli(Set<Tavolo> tavoli) {
      this.tavoli = tavoli;
   }

   public boolean addTavolo(Tavolo tavolo) {
      return this.tavoli.add(tavolo);
   }

   public boolean removeTavolo(Tavolo tavolo) {
      return this.tavoli.remove(tavolo);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
      result = prime * result + ((dataOra == null) ? 0 : dataOra.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((tavoli == null) ? 0 : tavoli.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Prenotazione other = (Prenotazione) obj;
      if (cliente == null) {
	 if (other.cliente != null) return false;
      } else if (!cliente.equals(other.cliente)) return false;
      if (dataOra == null) {
	 if (other.dataOra != null) return false;
      } else if (!dataOra.equals(other.dataOra)) return false;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (tavoli == null) {
	 if (other.tavoli != null) return false;
      } else if (!tavoli.equals(other.tavoli)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Prenotazione [id=");
      builder.append(id);
      builder.append(", dataOra=");
      builder.append(dataOra);
      builder.append(", cliente=");
      builder.append(cliente);
      builder.append(", tavoli=");
      builder.append(tavoli);
      builder.append("]");
      return builder.toString();
   }

}
