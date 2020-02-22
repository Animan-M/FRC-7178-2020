/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallMover extends SubsystemBase {
  /**
   * Creates a new BallMover.
   */
  public static WPI_TalonSRX m_middle;
  public static WPI_TalonSRX m_front;

  public BallMover() {
    m_middle = new WPI_TalonSRX(10);
    m_front = new WPI_TalonSRX(6);
  }
  
  public void ballForward() {
    m_middle.set(ControlMode.PercentOutput, -.5); //negative since upside down
    m_front.set(ControlMode.PercentOutput, .5);
  }

  public void ballBackward() {
    m_middle.set(ControlMode.PercentOutput, .3);
    m_front.set(ControlMode.PercentOutput, -0.2);
  }

  public void ballStop() {
    m_middle.set(ControlMode.PercentOutput, 0);
    m_front.set(ControlMode.PercentOutput, 0);
  }

}
