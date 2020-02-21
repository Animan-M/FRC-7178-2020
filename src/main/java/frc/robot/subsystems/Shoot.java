/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shoot extends SubsystemBase {
  /**
   * Creates a new Shoot.
   */
  public static WPI_TalonSRX m_topShoot;
  public static WPI_TalonSRX m_bottomShoot;
  public static WPI_TalonSRX m_shootMove;
  public static Solenoid m_ballPush;

  public Shoot() {
    m_topShoot = new WPI_TalonSRX(8);
    m_bottomShoot = new WPI_TalonSRX(7);
    m_shootMove = new WPI_TalonSRX(11);
    m_ballPush = new Solenoid(19, 0); //can id, pcm channel

    m_topShoot.setNeutralMode(NeutralMode.Coast);
    m_bottomShoot.setNeutralMode(NeutralMode.Coast);
  }

  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {
    if(RobotContainer.controller1.getRawButton(3) == true) {
      Shoot.m_topShoot.set(100);
      Shoot.m_bottomShoot.set(-100);
    } else if(RobotContainer.controller1.getRawButton(4) == true) {
      Shoot.m_ballPush.set(true);
      Shoot.m_topShoot.set(100);
      Shoot.m_bottomShoot.set(-100);
    } else {
      Shoot.m_topShoot.set(0);
      Shoot.m_bottomShoot.set(0);
      Shoot.m_ballPush.set(false);
    }
  }
}
