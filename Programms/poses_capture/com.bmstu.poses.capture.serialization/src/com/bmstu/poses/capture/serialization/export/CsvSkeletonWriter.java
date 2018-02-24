package com.bmstu.poses.capture.serialization.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonJoint;

/**
 *
 * CSV implementation of {@link ISkeletonWriter}.
 *
 * @author Bolshakov
 *
 */
public class CsvSkeletonWriter implements ISkeletonWriter {

	private static final char DELIMITER = ',';

	@Override
	public void exportSkeletons(Collection<Skeleton> skeletons, String pathToFile) {
		try (FileWriter writer = new FileWriter(pathToFile)) {
			for (Skeleton skeleton : skeletons) {
				writer.write(skeletonToCsv(skeleton) + System.lineSeparator());
			}

			writer.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String skeletonToCsv(Skeleton skeleton) {
		String result = "";
		for (SkeletonJoint skeletonJoint : skeleton.getJoints()) {
			result += skeletonJointToCsv(skeletonJoint) + DELIMITER;
		}
		//to remove last delimiter
		result = result.substring(0, result.length() - 1);

		return result;
	}

	private String skeletonJointToCsv(SkeletonJoint skeleton) {
		return "" + skeleton.getJointType().toNative() + DELIMITER + skeleton.getPosition().getX() + DELIMITER + skeleton.getPosition().getY() + DELIMITER + skeleton.getPosition().getZ() + DELIMITER + skeleton.getPositionConfidence() + DELIMITER + skeleton.getOrientation().getX() + DELIMITER + skeleton.getOrientation().getY() + DELIMITER + skeleton.getOrientation().getZ() + DELIMITER + skeleton.getOrientation().getW() + DELIMITER + skeleton.getOrientationConfidence();
	}
}
