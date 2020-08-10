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
package spa.simone.dto;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static spa.simone.restaurant.dao.DaoFactory.*;

import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsNull;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import spa.simone.restaurant.HibernateUtil;
import spa.simone.restaurant.dao.GenericDao;
import spa.simone.restaurant.dto.Azienda;
import spa.simone.restaurant.dto.Cameriere;
import spa.simone.restaurant.dto.Categoria;
import spa.simone.restaurant.dto.Cliente;
import spa.simone.restaurant.dto.Indirizzo;
import spa.simone.restaurant.dto.Ordinazione;
import spa.simone.restaurant.dto.Prenotazione;
import spa.simone.restaurant.dto.Privato;
import spa.simone.restaurant.dto.Tavolo;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
public class PersistenceTest {

   @AfterClass
   public static void shutDown() {
      HibernateUtil.getSessionFactory().close();
   }

   @Test
   public void checkPrivatoRowSize() {
      for (int i = 0; i < 10; i++) {
	 Privato privato = createPrivato("Nome" + Integer.toString(i),
	       "Cognome" + Integer.toString(9 - i));
	 getPrivatoDao().insert(privato);
      }
      List<Privato> result = getPrivatoDao().findAll();
      assertThat(result, hasSize(10));
      assertThat(result.size(), is(equalTo(10)));
   }

   @Test
   public void checkEqualityOfAzienda() {
      Azienda azienda1 = createAzienda("Google Inc.", "Silicon Valley", "Palo Alto",
	    "California (USA)");
      Long id = getAziendaDao().insert(azienda1);
      Azienda azienda2 = getAziendaDao().findById(id);
      assertThat(azienda1, is(equalTo(azienda2)));

      azienda1 = createAzienda("Patata Corp.", "Contrada Rocchi", "Rende", "Italia");
      getAziendaDao().insert(azienda1);
      azienda2 = createAzienda("Marmite S.r.l.", "Coffe Hall", "Milton Keynes", "United Kingdom");
      getAziendaDao().insert(azienda2);
      assertThat(azienda1, is(not(equalTo(azienda2))));
   }

   @Test
   public void insertAndDeleteCameriere() {
      Cameriere cameriere = createCameriere("Sara", "Cinesca", 13000);
      getCameriereDao().insert(cameriere);
      getCameriereDao().delete(cameriere);
      int size = getCameriereDao().findAll().size();
      assertThat(size, is(equalTo(0)));
   }

   @Test(expected = NullPointerException.class)
   public void checkTavolo() {
      Tavolo tavolo = getTavoloDao().findTavoloByNumber(0);
      assertThat(tavolo, is(nullValue()));
      tavolo.setNumeroPosti(3);	// a questo punto dovrebbe essere lanciata un'eccezione
   }

   private Categoria createCategoria(String nome) {
      Categoria categoria = new Categoria();
      categoria.setNome(nome);
      return categoria;
   }

   private Azienda createAzienda(String nome, String via, String città, String stato) {
      Azienda azienda = new Azienda();
      azienda.setNome(nome);
      Indirizzo indirizzo = new Indirizzo();
      indirizzo.setVia(via);
      indirizzo.setCittà(città);
      indirizzo.setStato(stato);
      azienda.setIndirizzo(indirizzo);
      return azienda;
   }

   private Prenotazione createPrenotazione(Date dataOra, Cliente cliente) {
      Prenotazione prenotazione = new Prenotazione();
      prenotazione.setDataOra(dataOra);
      prenotazione.setCliente(cliente);
      return prenotazione;
   }

   private Cameriere createCameriere(String nome, String cognome, Integer stipendio) {
      Cameriere cameriere = new Cameriere();
      cameriere.setNome(nome);
      cameriere.setCognome(cognome);
      cameriere.setStipendio(stipendio);
      return cameriere;
   }

   private Tavolo createTavolo(Integer numeroPosti, Integer numeroTavolo) {
      Tavolo tavolo = new Tavolo();
      tavolo.setNumeroPosti(numeroPosti);
      tavolo.setNumeroTavolo(numeroTavolo);
      return tavolo;
   }

   private Ordinazione createOrdinazione(Date data, Tavolo tavolo, Cliente cliente,
	 Cameriere cameriere) {
      Ordinazione ordinazione = new Ordinazione();
      ordinazione.setData(data);
      ordinazione.setTavolo(tavolo);
      ordinazione.setCliente(cliente);
      ordinazione.setCameriere(cameriere);
      return ordinazione;
   }

   private Privato createPrivato(String nome, String cognome) {
      Privato privato = new Privato();
      privato.setNome(nome);
      privato.setCognome(cognome);
      return privato;
   }

}