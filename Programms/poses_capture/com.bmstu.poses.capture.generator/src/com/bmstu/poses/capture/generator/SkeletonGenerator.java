package com.bmstu.poses.capture.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.bmstu.poses.capture.model.JointType;
import com.bmstu.poses.capture.model.Point3D;
import com.bmstu.poses.capture.model.Quaternion;
import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonJoint;
import com.bmstu.poses.capture.serialization.export.CsvSkeletonWriter;

/**
 *
 * Generates random skeletons.
 * Use {@link #SKELETONS_COUNT} to set generated skeletons count.
 *
 * @author Bolshakov
 *
 */
public class SkeletonGenerator {

	private static final int SKELETONS_COUNT = 4;
	private static final String GENERATE_FILE = "generated_skeletons.txt";

	/**
	 *
	 * Main method
	 *
	 */
	public static void main(String[] args) {
		new SkeletonGenerator().generateRandomSkeletons();
	}

	/**
	 *
	 * Generates random skeletons.
	 *
	 */
	public void generateRandomSkeletons() {
		Collection<Skeleton> skeletons = new ArrayList<>(SKELETONS_COUNT);
		for (int skeletonIndex = 0; skeletonIndex < SKELETONS_COUNT; skeletonIndex++) {
			skeletons.add(generateRandomSkeleton());
		}

		new CsvSkeletonWriter().exportSkeletons(skeletons, GENERATE_FILE);
	}

	private Skeleton generateRandomSkeleton() {
		List<SkeletonJoint> skeletonJoints = new ArrayList<>(JointType.values().length);
		for (int jointType = 0; jointType < JointType.values().length; jointType++) {
			skeletonJoints.add(generateSkeletonJoint(jointType));
		}

		return new Skeleton(skeletonJoints);
	}

	private SkeletonJoint generateSkeletonJoint(int jointType) {
		Random random = new Random();

		return new SkeletonJoint(jointType, generatePosition(), generateFloat(random), generateOrientation(), generateFloat(random));
	}

	private Point3D generatePosition() {
		Random random = new Random();
		return new Point3D(generateFloat(random), generateFloat(random), generateFloat(random));
	}

	private Quaternion generateOrientation() {
		Random random = new Random();
		return new Quaternion(generateFloat(random), generateFloat(random), generateFloat(random), generateFloat(random));
	}

	private float generateFloat(Random random) {
		return random.nextFloat();					// generates random skeletons
//		return random.nextFloat() / 10;				// generates sit skeleton state skeletons
//		return random.nextFloat() / 10 + 0.45f;		// generates stand skeleton state skeletons
//		return random.nextFloat() / 10 + 0.9f;		// generates jump skeleton state skeletons
	}
}
