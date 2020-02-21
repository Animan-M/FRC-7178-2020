/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shoot;

public class teleopShoot extends CommandBase {
  /**
   * Creates a new teleopShoot.
 * @param m_Shoot
   */
  public teleopShoot(Shoot m_Shoot) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Shoot);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shoot.m_ballPush.set(false); //true = on, false = off
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_Shoot.periodic();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
