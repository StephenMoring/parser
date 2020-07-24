package filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import models.Enrollee;

public class AscendingNameFilter implements Filter<List<List<Enrollee>>, List<List<Enrollee>>>{

	@Override
	public List<List<Enrollee>> process(List<List<Enrollee>> input) {
		List<List<Enrollee>> filesToWrite = new ArrayList<>();
		for(List<Enrollee> enrolleeList : input) {
			Collections.sort(enrolleeList, new Comparator<Enrollee>() {
			  @Override
			  public int compare(Enrollee e1, Enrollee e2) {
			    return e1.getName().split(" ")[1].compareTo(e2.getName().split(" ")[1]);
			  }
			});
			filesToWrite.add(enrolleeList);
    	}
		return filesToWrite;
	}

}
