package com.bmstu.poses.capture.serialization._import;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bmstu.poses.capture.model.JointType;
import com.bmstu.poses.capture.model.Point3D;
import com.bmstu.poses.capture.model.Quaternion;
import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonJoint;

/**
*
* String implementation of {@link ISkeletonReader}.
*
* @author Bolshakov
*
*/
public class StringSkeletonReader {

	private static final int SKELETON_JOINT_PARAMS_COUNT = 10;
	private static final String DELIMITER = ",";

	/**
	 *
	 * Reads skeletons from given string.
	 *
	 * @param string - string to read from. Can't be <code>null</code>.
	 *
	 * @return skeletons. Can't return <code>null</code>.
	 */
	public Collection<Skeleton> stringToSkeletons(String string) {
		return stringLinesToSkeletons(new BufferedReader(new StringReader(string)).lines().collect(Collectors.toList()));
	}

	/**
	 *
	 * Reads skeletons from given lines.
	 *
	 * @param lines - lines to read from. Can't be <code>null</code>.
	 *
	 * @return skeletons. Can't return <code>null</code>.
	 */
	public Collection<Skeleton> stringLinesToSkeletons(List<String> lines) {
		Collection<Skeleton> skeletons = new ArrayList<>();

		lines.stream().forEach(line -> skeletons.add(csvToSkeleton(line)));

		return skeletons;
	}

	private Skeleton csvToSkeleton(String line) {
		String[] params = line.split(DELIMITER);

		return new Skeleton(createSkeletonJoints(params));
	}

	private List<SkeletonJoint> createSkeletonJoints(String[] params) {
		List<SkeletonJoint> skeletonJoints = new ArrayList<>(JointType.values().length);
		for (int jointIndex = 0; jointIndex < JointType.values().length; jointIndex++)
		{
			int offset = jointIndex * SKELETON_JOINT_PARAMS_COUNT;

			skeletonJoints.add(new SkeletonJoint(Integer.valueOf(params[offset + 0]),
								new Point3D(Float.valueOf(params[offset + 1]), Float.valueOf(params[offset + 2]),
											Float.valueOf(params[offset + 3])),
								Float.valueOf(params[offset + 4]),
								new Quaternion(Float.valueOf(params[offset + 5]), Float.valueOf(params[offset + 6]),
												Float.valueOf(params[offset + 7]), Float.valueOf(params[offset + 8])),
								Float.valueOf(params[offset + 9])));
		}

		return skeletonJoints;
	}

}
