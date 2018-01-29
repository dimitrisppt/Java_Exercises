package preliminaries;


public class Marker {

	public int markAttempt(Exam examAttempt, Exam markScheme) {
		
		if ( examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() ) {
			
			examAttempt.Question1GiveMark(markScheme.Question1ReadMark());
			
		} else if ( examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() - 1 
				 || examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() + 1  ) {
			
			examAttempt.Question1GiveMark(markScheme.Question1ReadMark() - 1);
			
		} else if ( examAttempt.lookAtQuestion1Answer() >= markScheme.lookAtQuestion1Answer() - 5 
				 && examAttempt.lookAtQuestion1Answer() <= markScheme.lookAtQuestion1Answer() + 5  ) {
		
			examAttempt.Question1GiveMark(1);
		
		} else {
			
			examAttempt.Question1GiveMark(0);
			
		}
		
		if ( examAttempt.lookAtQuestion2Answer() == markScheme.lookAtQuestion2Answer() ) {
			
			examAttempt.Question2GiveMark(markScheme.Question2ReadMark());
			
		} else {
			
			examAttempt.Question2GiveMark(0);
			
		}
		
		if ( examAttempt.lookAtQuestion3Option1() == markScheme.lookAtQuestion3Option1()) {
			
			examAttempt.Question3GiveMark(examAttempt.Question3ReadMark() + 1);
	
		}
		
	    if ( examAttempt.lookAtQuestion3Option2() == markScheme.lookAtQuestion3Option2() ) {
			
			examAttempt.Question3GiveMark(examAttempt.Question3ReadMark() + 1);
			
		}
		
	    if ( examAttempt.lookAtQuestion3Option3() == markScheme.lookAtQuestion3Option3() ) {
			
			examAttempt.Question3GiveMark(examAttempt.Question3ReadMark() + 1);
			
		}
	    
	    int totalMark = examAttempt.Question1ReadMark() + examAttempt.Question2ReadMark() + examAttempt.Question3ReadMark();
	    		
	    examAttempt.writeTotalMark(totalMark);
	    
	    return totalMark;
	    
	}
	
	public double convertMarksToClassification(int mark, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary) {
		
		if ( mark >= firstBoundary ) {
			
			return 1.1;
			
		} else if ( mark >= upperSecondBoundary ) {
			
			return 2.1;
			
		} else if ( mark >= lowerSecondBoundary ) {
			
			return 2.2;
			
		} else {
			
			return 0.0;
			
		}
	
	}
	
}
