/*
 * Copyright 2016-2020 47 Degrees Open Source <https://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package stdlib

object NamedandDefaultArgumentsHelper {

  class WithoutClassParameters() {
    def addColors(red: Int, green: Int, blue: Int) =
      (red, green, blue)

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) =
      (red, green, blue)
  }

  class WithClassParameters(val defaultRed: Int, val defaultGreen: Int, val defaultBlue: Int) {
    def addColors(red: Int, green: Int, blue: Int) =
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) =
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }

  class WithClassParametersInClassDefinition(
      val defaultRed: Int = 0,
      val defaultGreen: Int = 255,
      val defaultBlue: Int = 100
  ) {
    def addColors(red: Int, green: Int, blue: Int) =
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) =
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
  }

}
