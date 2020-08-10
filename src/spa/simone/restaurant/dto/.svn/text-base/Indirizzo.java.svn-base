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

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Embeddable
public final class Indirizzo implements Serializable {

   private static final long serialVersionUID = -2119834104826271825L;
   private String via;
   private String città;
   private String stato;

   public Indirizzo() {
   }

   @Column(length = 50)
   public String getVia() {
      return via;
   }

   @Column(length = 50)
   public String getCittà() {
      return città;
   }

   @Column(length = 50)
   public String getStato() {
      return stato;
   }

   public void setVia(String via) {
      this.via = via;
   }

   public void setCittà(String città) {
      this.città = città;
   }

   public void setStato(String stato) {
      this.stato = stato;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((città == null) ? 0 : città.hashCode());
      result = prime * result + ((stato == null) ? 0 : stato.hashCode());
      result = prime * result + ((via == null) ? 0 : via.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
	 return true;
      }
      if (obj == null) {
	 return false;
      }
      if (getClass() != obj.getClass()) {
	 return false;
      }
      Indirizzo other = (Indirizzo) obj;
      if (città == null) {
	 if (other.città != null) {
	    return false;
	 }
      } else if (!città.equals(other.città)) {
	 return false;
      }
      if (stato == null) {
	 if (other.stato != null) {
	    return false;
	 }
      } else if (!stato.equals(other.stato)) {
	 return false;
      }
      if (via == null) {
	 if (other.via != null) {
	    return false;
	 }
      } else if (!via.equals(other.via)) {
	 return false;
      }
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(via).append(" - ");
      builder.append(città);
      builder.append(" (").append(stato).append(")");
      return builder.toString();
   }

}
