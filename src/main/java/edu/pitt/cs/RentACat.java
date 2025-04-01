package edu.pitt.cs;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*; 

public interface RentACat {
	public static RentACat createInstance(InstanceType type) {
		switch (type) {
			case IMPL:
				return new RentACatImpl();
			case BUGGY:
				return new RentACatBuggy();
			case SOLUTION:
				return new RentACatSolution();
			case MOCK:
				// TODO: Return a mock object that emulates the behavior of the real object, if you feel you need one.
				//actually not using
				RentACat rentACat=Mockito.mock(RentACat.class);
				Cat c1=new CatImpl(1, "Jennyanydots");
				Cat c2=new CatImpl(1, "Old Deuteronomy");
				Cat c3=new CatImpl(1, "Mistoffelees");
				Mockito.when(rentACat.rentCat(anyInt())).thenReturn(true);
				Mockito.when(rentACat.returnCat(anyInt())).thenReturn(true);
				Mockito.when(rentACat.renameCat(anyInt(),anyString())).thenReturn(true);
				Mockito.when(rentACat.listCats()).thenReturn("ID 1. Jennyanydots\nID 2. Old Deuteronomy\nID 3. Mistoffelees");
				return rentACat;
			default:
				assert (false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.

	public boolean returnCat(int id);

	public boolean rentCat(int id);

	public boolean renameCat(int id, String name);

	public String listCats();

	public void addCat(Cat c);
}
