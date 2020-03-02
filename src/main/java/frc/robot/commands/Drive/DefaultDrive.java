/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class DefaultDrive extends CommandBase {

  private final Chassis m_chassis;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_backward;
  private final DoubleSupplier m_turn;
  private double m_drive;

  public DefaultDrive(Chassis subsystem, DoubleSupplier forward, DoubleSupplier backward, DoubleSupplier turn) {
    m_chassis = subsystem;
    m_forward = forward;
    m_backward = backward;
    m_turn = turn;
    addRequirements(m_chassis);
   }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive = m_forward.getAsDouble() - m_backward.getAsDouble();
    m_chassis.arcadeDrive(m_drive/-1.05, m_turn.getAsDouble()/1.05);
  }
}
