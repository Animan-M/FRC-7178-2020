/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.teleopLiftUp;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift extends SubsystemBase {
  /**
   * Creates a new Lift.
   */

  public static WPI_TalonSRX m_leftLift;
  public static WPI_TalonSRX m_rightLift;

  public Lift() {
    m_leftLift = new WPI_TalonSRX(5);
    m_rightLift = new WPI_TalonSRX(10);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new teleopLiftUp());
  }

  public void liftSetUp() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(RobotContainer.controller1.getRawButton(1) == true) {
      m_leftLift.set(50);
      m_rightLift.set(50);
    } else if(RobotContainer.controller1.getRawButton(2) == true) {
      m_leftLift.set(-50);
      m_rightLift.set(-50);
    } else {
      m_leftLift.set(0);
      m_rightLift.set(0);
    }
  }
}
