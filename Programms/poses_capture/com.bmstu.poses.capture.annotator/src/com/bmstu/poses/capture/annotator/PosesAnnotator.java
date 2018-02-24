package com.bmstu.poses.capture.annotator;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.bmstu.poses.capture.SkeletonState;
import com.bmstu.poses.capture.serialization._import.StringSkeletonReader;

/**
 *
 * Poses annotator. Annotates poses.
 *
 * @author Bolshakov
 *
 */
public class PosesAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		String docText = jCas.getDocumentText();

		List<String> lines = new BufferedReader(new StringReader(docText)).lines().collect(Collectors.toList());

		int currentIndex = 0;
		Annotator annotator = new Annotator();
		StringSkeletonReader skeletonReader = new StringSkeletonReader();
		SkeletonState skeletonState = null;
		for (String line : lines) {
			String currentPoseName = annotator.annotate(skeletonReader.stringToSkeletons(line).iterator().next());
			if (currentPoseName != null) {
				if (skeletonState != null) {
					if (!currentPoseName.equals(skeletonState.getName())) {
						skeletonState.setEnd(currentIndex);
						skeletonState.addToIndexes();

						skeletonState = new SkeletonState(jCas);
						skeletonState.setBegin(currentIndex);
						skeletonState.setName(currentPoseName);
					}
				}
				else {
					skeletonState = new SkeletonState(jCas);
					skeletonState.setBegin(currentIndex);
					skeletonState.setName(currentPoseName);
				}
			}
			else {
				if (skeletonState != null) {
					skeletonState.setEnd(currentIndex);
					skeletonState.addToIndexes();
					skeletonState = null;
				}
			}

			currentIndex += line.length() + 1;
		}

		if (skeletonState != null) {
			skeletonState.setEnd(currentIndex);
			skeletonState.addToIndexes();
		}
	}

}
