package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

	Varasto varasto;
	double vertailuTarkkuus = 0.0001;

	@Before
	public void setUp() {
		varasto = new Varasto(10);
	}

	@Test
	public void konstruktoriLuoTyhjanVaraston() {
		assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
	}

	@Test
	public void uudellaVarastollaOikeaTilavuus() {
		assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
	}

	@Test
	public void lisaysLisaaSaldoa() {
		varasto.lisaaVarastoon(8);

		// saldon pitäisi olla sama kun lisätty määrä
		assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
	}

	@Test
	public void lisaysLisaaPienentaaVapaataTilaa() {
		varasto.lisaaVarastoon(8);

		// vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
		assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
	}

	@Test
	public void ottaminenPalauttaaOikeanMaaran() {
		varasto.lisaaVarastoon(8);

		double saatuMaara = varasto.otaVarastosta(2);

		assertEquals(2, saatuMaara, vertailuTarkkuus);
	}

	@Test
	public void ottaminenLisaaTilaa() {
		varasto.lisaaVarastoon(8);

		varasto.otaVarastosta(2);

		// varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
		assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
	}

	@Test
	public void laitaLiikaa() {
		varasto.lisaaVarastoon(12);

		// ei pit�isi mahtua varastoon
		assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
	}

	@Test
	public void otaLiikaa() {
		varasto.lisaaVarastoon(8);

		double saatuMaara = varasto.otaVarastosta(9);

		// varastossa ei ole tarpeeksi
		assertEquals(8, saatuMaara, vertailuTarkkuus);
	}

	@Test
	public void negatiivinenTilavuus() {
		Varasto varasto = new Varasto(-5);

		// Tilavuus 0
		assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
	}

	@Test
	public void otaNegatiivinen() {
		varasto.lisaaVarastoon(2);

		varasto.otaVarastosta(-9);

		// ei ota mit��n ei toimi??
		assertEquals(2.0, varasto.getSaldo(), vertailuTarkkuus);
	}
	
	@Test
	public void lisaaNegatiivinen() {
		varasto.lisaaVarastoon(-2);

		// ei ota mit��n ei toimi??
		assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
	}

   
	@Test
	public void stringi() {
		varasto.lisaaVarastoon(6);
		String vastaus = varasto.toString();

		// tulostus oikein Turha?
		assertEquals("saldo = 6.0, viel� tilaa 4.0", vastaus);
	}

	@Test
	public void kuormitusVarasto() {

		Varasto isoVarasto = new Varasto(20, 5);

		// varaston luonti onnistui
		assertEquals(20.0, isoVarasto.getTilavuus(), vertailuTarkkuus);
		assertEquals(5.0, isoVarasto.getSaldo(), vertailuTarkkuus);
	}

	@Test
	public void kuormitusNegTilavuus() {

		Varasto isoVarasto = new Varasto(-20, 5);

		// negatiivinen tilavuus ei toimi
		assertEquals(0.0, isoVarasto.getTilavuus(), vertailuTarkkuus);
		assertEquals(-20.0, isoVarasto.getSaldo(), vertailuTarkkuus);
	}

	@Test
	public void kuormitusIsoSaldo() {

		Varasto isoVarasto = new Varasto(10, 25);

		// isompi saldo
		assertEquals(10.0, isoVarasto.getTilavuus(), vertailuTarkkuus);
		assertEquals(10.0, isoVarasto.getSaldo(), vertailuTarkkuus);
	}

	@Test
	public void kuormitusNegSaldo() {

		Varasto isoVarasto = new Varasto(20, -5);

		// negatiivinen saldo
		assertEquals(20.0, isoVarasto.getTilavuus(), vertailuTarkkuus);
		assertEquals(0.0, isoVarasto.getSaldo(), vertailuTarkkuus);
	}

}