/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shoot extends SubsystemBase {
  /**
   * Creates a new Shoot.
   */
  public static WPI_TalonSRX m_topShoot;
  public static WPI_TalonSRX m_bottomShoot;
  public static Solenoid m_ballPush;

  public Shoot() {
    m_topShoot = new WPI_TalonSRX(8);
    m_bottomShoot = new WPI_TalonSRX(7);
    m_ballPush = new Solenoid(19, 0); //can id, pcm channel

    m_topShoot.setNeutralMode(NeutralMode.Coast);
    m_bottomShoot.setNeutralMode(NeutralMode.Coast);
  }

  public void Shooter() {
    m_topShoot.set(ControlMode.PercentOutput, -1);
    m_bottomShoot.set(ControlMode.PercentOutput, 1);
  }

  public void stopShooter() {
    m_topShoot.set(ControlMode.PercentOutput, 0);
    m_bottomShoot.set(ControlMode.PercentOutput, 0);
  }

  public void ballPushIn() {
    m_ballPush.set(true);
  }

  public void ballPushOut() {
    m_ballPush.set(false);
  }
}
