/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift extends SubsystemBase {
  /**
   * Creates a new Lift.
   */

  public static WPI_TalonSRX m_leftLift;
  public static WPI_TalonSRX m_rightLift;

  public Lift() {
    m_leftLift = new WPI_TalonSRX(14);
    m_rightLift = new WPI_TalonSRX(12);
  }

  public void LiftUp() {
    m_leftLift.set(ControlMode.PercentOutput, 0.5);
    m_rightLift.set(ControlMode.PercentOutput, 0.5);
  }

  public void LiftDown() {
    m_leftLift.set(ControlMode.PercentOutput, -0.5);
    m_rightLift.set(ControlMode.PercentOutput, -0.5);
  }

  public void StopLift() {
    m_leftLift.set(ControlMode.PercentOutput, 0);
    m_rightLift.set(ControlMode.PercentOutput, 0);
  }

 
}
