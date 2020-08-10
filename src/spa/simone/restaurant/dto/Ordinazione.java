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
@Entity(name = "ordinazione")
public final class Ordinazione implements Serializable {

   private static final long serialVersionUID = -2766615732576063399L;
   private Long id;
   private Date data;
   private Cliente cliente;
   private Tavolo tavolo;
   private Cameriere cameriere;
   private Set<ItemOrdinazione> itemOrdinazioni = new HashSet<ItemOrdinazione>();

   public Ordinazione() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Temporal(TemporalType.DATE)
   public Date getData() {
      return data;
   }

   @ManyToOne
   @JoinColumn(name = "id_cliente")
   @ForeignKey(name = "FK_ORDINAZIONE_CLIENTE")
   public Cliente getCliente() {
      return cliente;
   }

   @ManyToOne
   @JoinColumn(name = "id_tavolo")
   @ForeignKey(name = "FK_ORDINAZIONE_TAVOLO")
   public Tavolo getTavolo() {
      return tavolo;
   }

   @ManyToOne
   @JoinColumn(name = "id_cameriere")
   @ForeignKey(name = "FK_ORDINAZIONE_CAMERIERE")
   public Cameriere getCameriere() {
      return cameriere;
   }

   @ManyToMany
   @JoinTable(name = "ordinazione_item", joinColumns = @JoinColumn(name = "id_ordinazione"), inverseJoinColumns = @JoinColumn(name = "id_item"))
   @ForeignKey(name = "FK_ORDINAZIONE-ITEM_ORDINAZIONE", inverseName = "FK_ORDINAZIONE-ITEM_ITEM")
   public Set<ItemOrdinazione> getItemOrdinazioni() {
      return itemOrdinazioni;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setData(Date data) {
      this.data = data;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public void setTavolo(Tavolo tavolo) {
      this.tavolo = tavolo;
   }

   public void setCameriere(Cameriere cameriere) {
      this.cameriere = cameriere;
   }

   protected void setItemOrdinazioni(Set<ItemOrdinazione> itemOrdinazioni) {
      this.itemOrdinazioni = itemOrdinazioni;
   }

   public boolean addItemOrdinazione(ItemOrdinazione itemOrdinazione) {
      return this.itemOrdinazioni.add(itemOrdinazione);
   }

   public boolean removeItemOrdinazione(ItemOrdinazione itemOrdinazione) {
      return this.itemOrdinazioni.remove(itemOrdinazione);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cameriere == null) ? 0 : cameriere.hashCode());
      result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
      result = prime * result + ((data == null) ? 0 : data.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((itemOrdinazioni == null) ? 0 : itemOrdinazioni.hashCode());
      result = prime * result + ((tavolo == null) ? 0 : tavolo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Ordinazione other = (Ordinazione) obj;
      if (cameriere == null) {
	 if (other.cameriere != null) return false;
      } else if (!cameriere.equals(other.cameriere)) return false;
      if (cliente == null) {
	 if (other.cliente != null) return false;
      } else if (!cliente.equals(other.cliente)) return false;
      if (data == null) {
	 if (other.data != null) return false;
      } else if (!data.equals(other.data)) return false;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (itemOrdinazioni == null) {
	 if (other.itemOrdinazioni != null) return false;
      } else if (!itemOrdinazioni.equals(other.itemOrdinazioni)) return false;
      if (tavolo == null) {
	 if (other.tavolo != null) return false;
      } else if (!tavolo.equals(other.tavolo)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Ordinazione [id=");
      builder.append(id);
      builder.append(", data=");
      builder.append(data);
      builder.append(", cliente=");
      builder.append(cliente);
      builder.append(", tavolo=");
      builder.append(tavolo);
      builder.append(", cameriere=");
      builder.append(cameriere);
      builder.append(", itemOrdinazioni=");
      builder.append(itemOrdinazioni);
      builder.append("]");
      return builder.toString();
   }

}
