package org.knoxcraft.turtle3d;

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Direction.Division;

import com.flowpowered.math.vector.Vector3d;

/**
 * @author kakoijohn
 *
 */
/**
 * @author kakoijohn
 *
 */
/**
 * @author kakoijohn
 *
 */
public enum TurtleDirection {
	NORTH(new Vector3d(0, 0, -1), Division.CARDINAL),    //North(0, 0, -1) = 0
    NORTHEAST(new Vector3d(1, 0, -1), Division.ORDINAL), //NorthEast(1, 0, -1) = 1

    EAST(new Vector3d(1, 0, 0), Division.CARDINAL),      //East(1, 0, 0) = 2
    SOUTHEAST(new Vector3d(1, 0, 1), Division.ORDINAL),  //SouthEast(1, 0, 1) = 3

    SOUTH(new Vector3d(0, 0, 1), Division.CARDINAL),     //South(0, 0, 1) = 4
    SOUTHWEST(new Vector3d(-1, 0, 1), Division.ORDINAL), //SouthWest(-1, 0, 1) = 5

    WEST(new Vector3d(-1, 0, 0), Division.CARDINAL),     //West(-1, 0, 0) = 6
    NORTHWEST(new Vector3d(-1, 0, -1), Division.ORDINAL),//NorthWest(-1, 0, -1) = 7

	UP(new Vector3d(0, 1, 0), Division.CARDINAL),        //Up(0, 1, 0) = 8
    DOWN(new Vector3d(0, -1, 0), Division.CARDINAL),     //Down(0, -1, 0) = 9
	
	NONE(new Vector3d(0, 0, 0), Division.NONE);          //None(0, 0, 0) = 10

	private final Vector3d direction;
	private final Division division;
	
	TurtleDirection(Vector3d vector3d, Division division) {
	    if (vector3d.lengthSquared() == 0) {
	        // Prevent normalization of the zero direction
	        this.direction = vector3d;
	    } else {
	        this.direction = vector3d.normalize();
	    }
	    this.division = division;
	}
	
	public static TurtleDirection valueOf(int val) {
	    return TurtleDirection.values()[val];
	}
	
	public int getIntValue() {
	    return ordinal();
	}
	
	/**
	 * @return the opposite direction of the current heading.
	 */
	public TurtleDirection flip () {
		if (this == UP)
			return DOWN;
		else if (this == DOWN)
			return UP;
		
		int currentDir = this.getIntValue();
		int newDir = (currentDir+4)%8;
		return TurtleDirection.valueOf(newDir);
	}
	
	public TurtleDirection turn(boolean left, int units) {
		int currentDir = this.getIntValue();
		if (left) {
			int newDir = currentDir - units;
			while (newDir < 0) {
				newDir += 8;
			}
			return TurtleDirection.valueOf(newDir);
		} else {
			int newdir = currentDir + units;
			newdir = newdir % 8;
			return TurtleDirection.valueOf(newdir);
		}
	}
}
