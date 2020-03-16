/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ArmConstants {
        public static final int kArmMotorPort = 14;
        public static final int kArmEncoderStartPosition = 0;

        public static final double kArmUpSpeed = 0.5;
        public static final double kArmDownSpeed = -0.5;
        public static final double kArmRestSpeed = 0;
    }

    public static final class BallMoverConstants {
        public static final int kMiddleMotorPort = 10;
        public static final int kFrontMotorPort = 6;
        public static final int kMiddleWheelMotorPort = 16;

        public static final double kMiddleForwardSpeed = -0.35;
        public static final double kFrontForwardSpeed = 0.45;
        public static final double kMiddleWheelForwardSpeed = 0.5;

        public static final double kMiddleReverseSpeed = 0.3;
        public static final double kFrontReverseSpeed = -0.2;

        public static final double kMiddleRestSpeed = 0;
        public static final double kFrontRestSpeed = 0;
        public static final double kMiddleWheelRestSpeed = 0;

        public static final double kMiddleAutoForwardSpeed = -0.3;
        public static final double kFrontAutoForwardSpeed = 0.2;
        public static final double kMiddleWheelAutoSpeed = 0.5;        
    }

    public static final class DriveConstants {
        public static final int kFrontLeftMotorPort = 1;
        public static final int kFrontRightMotorPort = 2;
        public static final int kBackLeftMotorPort = 3;
        public static final int kBackRightMotorPort = 4;
    }

    public static final class IntakeConstants {
        public static final int kIntakeMotorPort = 5;
        public static final int kBackBeltMotorPort = 9;
        public static final int kAirCompressorPort = 19;

        public static final int kIntakeSolenoidPort = 19;
        public static final int kIntakeSolenoidPCM = 1;

        public static final double kIntakeBeltForwardSpeed = 1;
        public static final double kIntakeBeltReverseSpeed = -1;
        public static final double kIntakeBeltRestSpeed = 0;
        
        public static final double kBackBeltForwardSpeed = 0.65;
        public static final double kBackBeltReverseSpeed = -0.8;
        public static final double kBackBeltRestSpeed = 0;

        public static final boolean kIntakeSolenoidDeploy = true;
        public static final boolean kIntakeSolenoidRetract = false;
    }

    public static final class LiftConstants {
        public static final int kLeftMotorPort = 12;
        public static final int kRightMotorPort = 15;

        public static final int kLeftMotorStartPosition = 0;
        public static final int kRightMotorStartPosition = 0;

        public static final double kLeftLiftUpSpeed = 0.35;
        public static final double kRightLiftUpSpeed = 0.4;

        public static final double kLeftLiftDownSpeed = -0.45;
        public static final double kRightLiftDownSpeed = -0.5;

        public static final double kLeftLiftRestSpeed = 0;
        public static final double kRightLiftRestSpeed = 0;

        public static final int kLeftLiftEncoderLimit = 160000;
        public static final int kRightLiftEncoderLimit = 160000;
    }

    public static final class PivotConstants {
        public static final int kPivotMotorPort = 11;
        public static final int kPivotMotorStartPosition = 0;

        public static final int kTopEncoderThreshold = 175;
        public static final int kBottomEncoderThreshold = 155;

        public static final double kShootForwardSpeed = 0.15;

        public static final double kShootBackwardSpeed = -0.15;

        public static final double kShootRestSpeed = 0;
    }

    public static final class ShootConstants {
        public static final int kShootTopMotorPort = 8;
        public static final int kShootBottomMotorPort = 7;
        public static final int kShootFlipperPort = 19;
        public static final int kShootFlipperChannel = 0;

        public static final double kTopShooterForwardSpeed = -1;
        public static final double kBottomShooterForwardSpeed = 1;

        public static final double kTopShooterRestSpeed = 0;
        public static final double kBottomShooterRestSpeed = 0; 
    }

    public static final class WOFConstants {
        public static final int kSpinnerMotorPort = 13;

        public static final double kSpinnerForwardSpeed = 0.5;

        public static final double kSpinnerBackwardSpeed = -0.5;

        public static final double kSpinnerRestSpeed = 0;
    }

}
