package eu.timepit.refined.types

import eu.timepit.refined.W
import eu.timepit.refined.api.{Refined, RefinedTypeOps}
import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.string.MatchesRegex

/** Module for `String` refined types. */
object string {

  /** A `String` that is not empty. */
  type NonEmptyString = String Refined NonEmpty

  object NonEmptyString extends RefinedTypeOps[NonEmptyString, String]

  /** A `String` that contains no leading or trailing whitespace. */
  type TrimmedString = String Refined MatchesRegex[W.`"""^(?!\\s).*(?<!\\s)"""`.T]

  object TrimmedString extends RefinedTypeOps[TrimmedString, String]

  /** A `String` representing a hexadecimal number */
  type HexStringSpec = MatchesRegex[W.`"""^(([0-9a-f]+)|([0-9A-F]+))$"""`.T]
  type HexString = String Refined HexStringSpec
  object HexString extends RefinedTypeOps[HexString, String]
}

trait StringTypes {
  final type NonEmptyString = string.NonEmptyString
  final val NonEmptyString = string.NonEmptyString

  final type TrimmedString = string.TrimmedString
  final val TrimmedString = string.TrimmedString

  final type HexString = string.HexString
  final val HexString = string.HexString
}
