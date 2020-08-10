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
package spa.simone.restaurant;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spa.simone.restaurant.dto.Accordo;
import spa.simone.restaurant.dto.Azienda;
import spa.simone.restaurant.dto.Cameriere;
import spa.simone.restaurant.dto.Categoria;
import spa.simone.restaurant.dto.Cliente;
import spa.simone.restaurant.dto.Indirizzo;
import spa.simone.restaurant.dto.Ingrediente;
import spa.simone.restaurant.dto.ItemOrdinazione;
import spa.simone.restaurant.dto.MenuFisso;
import spa.simone.restaurant.dto.Ordinazione;
import spa.simone.restaurant.dto.Pietanza;
import spa.simone.restaurant.dto.Prenotazione;
import spa.simone.restaurant.dto.Privato;
import spa.simone.restaurant.dto.Tavolo;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
public class HibernateUtil {

   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
	 Configuration conf = new Configuration();
	 conf.addAnnotatedClass(Accordo.class);
	 conf.addAnnotatedClass(Azienda.class);
	 conf.addAnnotatedClass(Cameriere.class);
	 conf.addAnnotatedClass(Categoria.class);
	 conf.addAnnotatedClass(Cliente.class);
	 conf.addAnnotatedClass(Indirizzo.class);
	 conf.addAnnotatedClass(Ingrediente.class);
	 conf.addAnnotatedClass(ItemOrdinazione.class);
	 conf.addAnnotatedClass(MenuFisso.class);
	 conf.addAnnotatedClass(Ordinazione.class);
	 conf.addAnnotatedClass(Pietanza.class);
	 conf.addAnnotatedClass(Prenotazione.class);
	 conf.addAnnotatedClass(Privato.class);
	 conf.addAnnotatedClass(Tavolo.class);
	 conf.configure("hsqldb.cfg.xml");
	 sessionFactory = conf.buildSessionFactory();
      }
      return sessionFactory;
   }
}