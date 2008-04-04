/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2008, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */

package schemacrawler.main;


import schemacrawler.schemacrawler.Config;
import sf.util.CommandLineParser.Option;
import sf.util.CommandLineParser.StringOption;

/**
 * Parses the command line.
 * 
 * @author Sualeh Fatehi
 */
final class ConfigParser
  extends BaseCommandLineParser<Config>
{

  private final StringOption optionConfigFile = new StringOption('g',
                                                                 "configfile",
                                                                 "schemacrawler.config.properties");
  private final StringOption optionConfigOverrideFile = new StringOption('p',
                                                                         "configoverridefile",
                                                                         "schemacrawler.config.override.properties");

  ConfigParser(final String[] args)
  {
    super(args);
  }

  @Override
  protected Config getValue()
  {
    parse(new Option[] {
        optionConfigFile, optionConfigOverrideFile
    });

    final String cfgFile = optionConfigFile.getValue();
    final String cfgOverrideFile = optionConfigOverrideFile.getValue();
    return Config.load(cfgFile, cfgOverrideFile);
  }

}
