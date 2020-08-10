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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "menufisso")
public final class MenuFisso extends ItemOrdinazione {

   private static final long serialVersionUID = -2988091879748637131L;
   private String nome;
   private Set<Accordo> accordi = new HashSet<Accordo>();
   private Set<Categoria> categorie = new HashSet<Categoria>();

   public MenuFisso() {
   }

   public String getNome() {
      return nome;
   }

   @OneToMany(mappedBy = "menuFisso")
   public Set<Accordo> getAccordi() {
      return accordi;
   }

   @ManyToMany
   @JoinTable(name = "menufisso_categoria", joinColumns = @JoinColumn(name = "id_menufisso"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
   @ForeignKey(name = "FK_MENUFISSO-CATEGORIA_MENUFISSO", inverseName = "FK_MENUFISSO-CATEGORIA_CATEGORIA")
   public Set<Categoria> getCategorie() {
      return categorie;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   protected void setAccordi(Set<Accordo> accordi) {
      this.accordi = accordi;
   }

   public boolean addAccordo(Accordo accordo) {
      return this.accordi.add(accordo);
   }

   public boolean removeAccordo(Accordo accordo) {
      return this.accordi.remove(accordo);
   }

   protected void setCategorie(Set<Categoria> categorie) {
      this.categorie = categorie;
   }

   public boolean addCategoria(Categoria categoria) {
      return this.categorie.add(categoria);
   }

   public boolean removeCategoria(Categoria categoria) {
      return this.categorie.remove(categoria);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      MenuFisso other = (MenuFisso) obj;
      if (categorie == null) {
	 if (other.categorie != null) return false;
      } else if (!categorie.equals(other.categorie)) return false;
      if (nome == null) {
	 if (other.nome != null) return false;
      } else if (!nome.equals(other.nome)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("MenuFisso [nome=");
      builder.append(nome);
      builder.append(", categorie=");
      builder.append(categorie);
      builder.append("]");
      return builder.toString();
   }

}