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
import javax.persistence.ManyToMany;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ItemOrdinazione implements Serializable {

   private static final long serialVersionUID = 4827924860763534246L;
   private Long id;
   private Integer prezzo;
   private Set<Ordinazione> ordinazioni = new HashSet<Ordinazione>();

   public ItemOrdinazione() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   public Long getId() {
      return id;
   }

   @Column(length = 4)
   public Integer getPrezzo() {
      return prezzo;
   }

   @ManyToMany(mappedBy = "itemOrdinazioni")
   public Set<Ordinazione> getOrdinazioni() {
      return ordinazioni;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setPrezzo(Integer prezzo) {
      this.prezzo = prezzo;
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
      result = prime * result + ((prezzo == null) ? 0 : prezzo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (!(obj instanceof ItemOrdinazione)) return false;
      ItemOrdinazione other = (ItemOrdinazione) obj;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (prezzo == null) {
	 if (other.prezzo != null) return false;
      } else if (!prezzo.equals(other.prezzo)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("ItemOrdinazione [id=");
      builder.append(id);
      builder.append(", prezzo=");
      builder.append(prezzo);
      builder.append("]");
      return builder.toString();
   }

}