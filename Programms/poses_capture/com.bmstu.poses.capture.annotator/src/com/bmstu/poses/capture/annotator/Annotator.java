package com.bmstu.poses.capture.annotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.bmstu.poses.capture.DefaultSkeletonStateIdentifier;
import com.bmstu.poses.capture.model.JointType;
import com.bmstu.poses.capture.model.Point3D;
import com.bmstu.poses.capture.model.Quaternion;
import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonJoint;
import com.bmstu.poses.capture.model.SkeletonState;

/**
 * Skeletons annotator.
 *
 * @author Bolshakov
 */
public class Annotator {

	private static final List<String> SKELETON_STATES_TITLES = Arrays.asList("Sit", "Stand", "Jump");

	/**
	 *
	 * Returns state name of given skeleton.
	 *
	 * @param skeleton - skeleton to get state name. Can't be <code>null</code>.
	 *
	 * @return returns skeleton state name. Can return <code>null</code>.
	 */
	public String annotate(Skeleton skeleton) {
		Collection<SkeletonState> skeletonStates = loadSkeletonStates();
		SkeletonState state = new DefaultSkeletonStateIdentifier().identify(skeleton, skeletonStates);
		return state != null ? state.getName() : null;
	}

	private Collection<SkeletonState> loadSkeletonStates() {
		Collection<SkeletonState> skeletonStates = new ArrayList<>(SKELETON_STATES_TITLES.size());
		int index = 0;
		for (String skeletonStateTitle : SKELETON_STATES_TITLES) {
			skeletonStates.add(new SkeletonState(skeletonStateTitle, createSkeleton(index)));
			index++;
		}

		return skeletonStates;
	}

	private Skeleton createSkeleton(int index) {
		List<SkeletonJoint> joints = new ArrayList<>(JointType.values().length);
		float skeletonValue = index * 0.5f;
		for (int jointIndex = 0; jointIndex < JointType.values().length; jointIndex++) {
			joints.add(new SkeletonJoint(jointIndex, new Point3D(skeletonValue, skeletonValue, skeletonValue), 1f,
										new Quaternion(skeletonValue, skeletonValue, skeletonValue, skeletonValue), 1f));
		}

		return new Skeleton(joints);
	}
}
