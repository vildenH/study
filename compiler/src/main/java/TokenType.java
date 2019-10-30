/**
 * @author wh
 * @date 2019/10/10
 */
public enum TokenType {
  Plus,   // +
  Minus,  // -
  Star,   // *
  Slash,  // /

  GE,     // >=
  GT,     // >
  EQ,     // ==
  LE,     // <=
  LT,     // <

  SemiColon, // ;
  LeftParen, // (
  RightParen,// )

  Assignment,// =

  If,
  Else,

  Int,

  Identifier,     //标识符

  IntLiteral,     //整型字面量
  StringLiteral   //字符串字面量
}
