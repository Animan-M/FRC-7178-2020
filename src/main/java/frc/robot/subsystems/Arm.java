/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
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

  public static boolean _armTop = false;
  public static boolean _armBottom = false;
  public static boolean armState = false;

  public Arm() {
    m_armMove = new WPI_TalonSRX(15);

  }

  public boolean ArmUp() {
    armState = _up_nc.get();

    return armState;
  }

  public void LiftArmUp() {
    m_armMove.set(ControlMode.PercentOutput, 0.1);
  }

  public void WOFArmUp() {
    m_armMove.set(ControlMode.PercentOutput, 0.1);
  }

  public void ArmDown() {
    m_armMove.set(ControlMode.PercentOutput, -0.1);
  }

  public void ArmStop() {
    m_armMove.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top Limit", _up_nc.get());
    SmartDashboard.putBoolean("Bottom Limit", _dn_nc.get());
  }
}
