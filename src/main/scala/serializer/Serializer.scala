package serializer

trait Serializer[A] {
 def stringfy(value: A): String
}

