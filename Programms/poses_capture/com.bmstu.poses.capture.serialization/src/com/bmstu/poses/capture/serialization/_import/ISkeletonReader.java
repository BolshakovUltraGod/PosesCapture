package com.bmstu.poses.capture.serialization._import;

import java.util.Collection;

import com.bmstu.poses.capture.model.Skeleton;

/**
*
* Instances of this class can import skeletons from files.
*
* @author Bolshakov
*
*/
public interface ISkeletonReader {

	/**
	 *
	 * Import skeletons from given file.
	 *
	 * @param pathToFile - path to file to import from. Can't be <code>null</code>.
	 *
	 * @return deserialized skeletons.
	 */
	Collection<Skeleton> importSkeletons(String pathToFile);

}
