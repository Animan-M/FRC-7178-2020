/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   */
 
  public static WPI_TalonSRX m_armMove;
  public static DigitalInput _up_nc = new DigitalInput(0);
  public static DigitalInput _dn_nc = new DigitalInput(1);
  public static DigitalInput _top = new DigitalInput(2); //top
  public static DigitalInput _input4 = new DigitalInput(3); //bottom
  public static DigitalInput _input5 = new DigitalInput(4); 

  public static boolean _armTop = false;
  public static boolean _armBottom = false;
  public static boolean armState = false;

  public Arm() {
    m_armMove = new WPI_TalonSRX(14);
    m_armMove.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_armMove.setSelectedSensorPosition(0);
  }

  public boolean ArmUp() {
    armState = _top.get();

    return armState;
  }

  public void LiftArmUp() {
    m_armMove.set(ControlMode.PercentOutput, 0.3);
  }

  public void ArmDown() {
    m_armMove.set(ControlMode.PercentOutput, -0.3);
  }

  public void ArmStop() {
    m_armMove.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top", _top.get());
    SmartDashboard.putBoolean("Bottom", _input4.get());
    SmartDashboard.putNumber("Arm Encoder", m_armMove.getSelectedSensorPosition());
  }
}
