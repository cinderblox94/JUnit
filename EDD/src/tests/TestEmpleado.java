package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleado 
{
	@Test 
	public void establecerNumeroDeEmpleadoCorrecto() 
	{
		Empleado e = new Empleado();
        try 
        {
            e.establecerNumeroEmpleado("4");
        } catch (NumeroEmpleadoException ex) 
        {
        	fail("Error número empleado");
        }
        assertEquals(4,e.getNumeroEmpleado());
	}
	
	@Test 
	public void estableceNombreEmpleadoTest() {
		Empleado e0 = new Empleado();
		Empleado e1 = new Empleado();
		Empleado e2= new Empleado();
		Empleado e3 = new Empleado();
		String nomBien = "a1b2c3d4e5";
		String nomMal = "a";
		String nomMal2 = "a1b2c3d4e5f";
		String nomMal3 = null;
		
		
			try {
				e0.estableceNombreEmpleado(nomBien);
			} catch (NombreEmpleadoException ex) {
				fail();
			}
			try {
				e1.estableceNombreEmpleado(nomMal);
			} catch (NombreEmpleadoException ex) { 
				assert(ex instanceof NombreEmpleadoException);
			}
			try {
				e2.estableceNombreEmpleado(nomMal2);
			} catch (NombreEmpleadoException ex) { 
				assert(ex instanceof NombreEmpleadoException);
			}
			try {
				e3.estableceNombreEmpleado(nomMal3);
			} catch (NullPointerException ex) { 
				assert(ex instanceof NullPointerException);
			} catch (NombreEmpleadoException ex) {
					fail();
			}
			
		
		
		assertEquals("a1b2c3d4e5", e0.getNombreEmpleado());
		
	}
		

	@Test
	public void estableceMesesTrabajoTest() {
		Empleado e0 = new Empleado();
		Empleado e1 = new Empleado();
		Empleado e2= new Empleado();
		Empleado e3 = new Empleado();
		Empleado e4 = new Empleado();
		Empleado e5 = new Empleado();
		Empleado e6= new Empleado();
		
		String mesBien1 = "000";
		String mesBien2 = "999";
		String mesMal1 = "1234";
		String mesMal2 = "12";
		String mesMal3 = "-12";
		String mesMal4 = "aaa";
		String mesMal5 = null;
		
			try {
				e0.estableceMesesTrabajo(mesBien1);
			} catch (MesesTrabajoException ex) {
				fail();
			}
			assertEquals(000, e0.getMesesTrabajo());
			
			
			try {
				e1.estableceMesesTrabajo(mesBien2);
			} catch (MesesTrabajoException ex) {
				fail();
			}
			assertEquals(999, e1.getMesesTrabajo());
			
			
			try {
				e2.estableceMesesTrabajo(mesMal1);
			} catch (MesesTrabajoException ex) {
				assert(ex instanceof MesesTrabajoException);
			}
						
			try {
				e3.estableceMesesTrabajo(mesMal2);
				if(Integer.toString(e3.getMesesTrabajo()).length()==3)
					throw new MesesTrabajoException ();
			} catch (MesesTrabajoException ex) {
				assert(ex instanceof MesesTrabajoException);
			}
				
			try {
				e4.estableceMesesTrabajo(mesMal3);
			} catch (MesesTrabajoException ex) {
				assert(ex instanceof MesesTrabajoException);
			}
			try {
				e5.estableceMesesTrabajo(mesMal4);
			} catch (MesesTrabajoException ex) {
				assert(ex instanceof MesesTrabajoException);
			}
			try {
				e6.estableceMesesTrabajo(mesMal5);
			} catch (MesesTrabajoException ex) {
				fail();
			} catch (NullPointerException ex) {
				assert(ex instanceof NullPointerException);
			}
	}

	@Test
	public void establecerSerDirectivoTest() {
		Empleado e0 = new Empleado();
		Empleado e1 = new Empleado();
		Empleado e2= new Empleado();
		Empleado e3 = new Empleado();
		Empleado e4 = new Empleado();
		Empleado e5 = new Empleado();
		Empleado e6 = new Empleado();
		String direc1 = "-";
		String direc2 = "+";
		String direc3 = "1";
		String direc4 = "a";
		String direc5 = "/";
		String direc6 = null;
		String direc7 = "++";
		
		try {
			e0.establecerSerDirectivo(direc1);
		}catch(CargoException ex) {
			fail();
		}
		assertEquals(false, e0.getDirectivo());
		
		try {
			e1.establecerSerDirectivo(direc2);
			}catch(CargoException ex) {
				fail();
			}
		assertEquals(true, e1.getDirectivo());
		
		try {
			e2.establecerSerDirectivo(direc3);
			}catch(CargoException ex) {
				assert(ex instanceof CargoException);
			}	
		
		try {
			e3.establecerSerDirectivo(direc4);
			}catch(CargoException ex) {
				assert(ex instanceof CargoException);
			}	
		
		try {
			e4.establecerSerDirectivo(direc5);
			}catch(CargoException ex) {
				assert(ex instanceof CargoException);
			}
		
		try {
			e5.establecerSerDirectivo(direc6);
			}catch(CargoException ex) {
				assert(ex instanceof CargoException);
			}catch(NullPointerException ex) {
				assert(ex instanceof NullPointerException);
			}
		
		try {
			e6.establecerSerDirectivo(direc7);
			}catch(CargoException ex) {
				assert(ex instanceof CargoException);
			}
	}
	
	@Test
	public void calcularPrimaTest0() {
		Empleado e0 = new Empleado();
		Empleado e1 = new Empleado();
		Empleado e2= new Empleado();
		Empleado e3 = new Empleado();
		try {
			
			e0.calcularPrima("123", "a1b2c3d4e5", "012", "+");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		assertEquals(Prima.P1, e0.getPrima());
	
		try {
			
			e1.calcularPrima("123", "a1b2c3d4e5", "013", "-");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();		
			}
		assertEquals(Prima.P2, e1.getPrima());
		
		try {
			
			e2.calcularPrima("123", "a1b2c3d4e5", "01", "+");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();	
			}
		assertEquals(Prima.P3, e2.getPrima());
	
		try {
			
			e3.calcularPrima("123", "a1b2c3d4e5", "011", "-");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
			}
		assertEquals(Prima.P4, e3.getPrima());
	}
}
