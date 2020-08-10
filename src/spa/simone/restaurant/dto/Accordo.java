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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "accordo")
public final class Accordo implements Serializable {

   private static final long serialVersionUID = 5626008240619251954L;
   private Long id;
   private Integer prezzo;
   private Azienda azienda;
   private MenuFisso menuFisso;

   public Accordo() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Column(nullable = false)
   public Integer getPrezzo() {
      return prezzo;
   }

   @ManyToOne
   @JoinColumn(name = "id_azienda", nullable = false)
   @ForeignKey(name = "FK_ACCORDO_AZIENDA")
   public Azienda getAzienda() {
      return azienda;
   }

   @ManyToOne
   @JoinColumn(name = "id_menufisso", nullable = false)
   @ForeignKey(name = "FK_ACCORDO_MENUFISSO")
   public MenuFisso getMenuFisso() {
      return menuFisso;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setPrezzo(Integer prezzo) {
      this.prezzo = prezzo;
   }

   public void setAzienda(Azienda azienda) {
      this.azienda = azienda;
   }

   public void setMenuFisso(MenuFisso menuFisso) {
      this.menuFisso = menuFisso;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((azienda == null) ? 0 : azienda.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((menuFisso == null) ? 0 : menuFisso.hashCode());
      result = prime * result + ((prezzo == null) ? 0 : prezzo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Accordo other = (Accordo) obj;
      if (azienda == null) {
	 if (other.azienda != null) return false;
      } else if (!azienda.equals(other.azienda)) return false;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (menuFisso == null) {
	 if (other.menuFisso != null) return false;
      } else if (!menuFisso.equals(other.menuFisso)) return false;
      if (prezzo == null) {
	 if (other.prezzo != null) return false;
      } else if (!prezzo.equals(other.prezzo)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Accordo [id=");
      builder.append(id);
      builder.append(", prezzo=");
      builder.append(prezzo);
      builder.append(", azienda=");
      builder.append(azienda);
      builder.append(", menuFisso=");
      builder.append(menuFisso);
      builder.append("]");
      return builder.toString();
   }

}
