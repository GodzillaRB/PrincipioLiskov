import java.math.BigDecimal

// Clase abstracta que representa una venta y es la clase Abuelo, ya que tiene otras clases que heradan de ella
abstract class AbstractSale {
    // Es la clase base para todas las ventas. Tiene dos métodos abstractos: generate() y xml().
    // Estos métodos deben ser implementados por las clases hijas.
    abstract fun generate()
    abstract fun xml()
}

// Clase abstracta que representa una venta con impuestos y es la clase padre.
// Ya que tiene otras clases que heredan de esta, pero esta hereda de la clase AbstractSale.
abstract class SaleWithTaxes : AbstractSale() {
    // Hereda de AbstractSale. Esta clase también es abstracta y agrega otro método abstracto: calculateTaxes().
    // Las clases hijas de SaleWithTaxes deben proporcionar una implementación para este método.
    abstract fun calculateTaxes()
}

// Clase que representa una venta local y es una clase hija que hereda de SaleWithTaxes


// Se definen tres clases concretas: LocalSale, ForeignSale y SaleInvoice, todas heredan de SaleWithTaxes así que son consideradas clases hijas.

//La clase LocalSale representa una venta local y tiene tres propiedades: amount (monto), customer (cliente) y taxes (impuestos).
//Implementa los métodos generate(), calculateTaxes() y xml(), que simplemente imprimen mensajes en la consola.
class LocalSale(private val amount: BigDecimal, private val customer: String, private val taxes: BigDecimal) :
    SaleWithTaxes() {

    // Implementación del método generate de la clase AbstractSale
    override fun generate() {
        println("Se genera la venta")
    }
    // Implementación del método calculateTaxes de la clase SaleWithTaxes
    override fun calculateTaxes() {
        println("Se calculan los impuestos")
    }
    // Implementación del método xml de la clase AbstractSale
    override fun xml() {
        println("Se genera el XML de la Factura")
    }
}

// La clase ForeignSale representa una venta internacional y tiene dos propiedades: amount y customer. Al igual que LocalSale.
// Implementa los mismos metodos que LocalSale
class ForeignSale(private val amount: BigDecimal, private val customer: String) : SaleWithTaxes() {

    // Implementación del método generate de la clase AbstractSale
    override fun generate() {
        println("Se genera la venta")
    }

    // Implementación del método calculateTaxes de la clase SaleWithTaxes
    override fun calculateTaxes() {
        println("Se calculan los impuestos")
    }

    // Implementación del método xml de la clase AbstractSale
    override fun xml() {
        println("Se genera el XML de la Factura")
    }
}

// La clase SaleInvoice representa una factura de venta y tiene las mismas propiedades que LocalSale y ForeignSale. Implementa los mismos métodos
class SaleInvoice(private val amount: BigDecimal, private val customer: String, private val taxes: BigDecimal) :
    SaleWithTaxes() {

    // Implementación del método generate de la clase AbstractSale
    override fun generate() {
        println("Se genera la venta")
    }

    // Implementación del método calculateTaxes de la clase SaleWithTaxes
    override fun calculateTaxes() {
        println("Se calculan los impuestos")
    }

    // Implementación del método xml de la clase AbstractSale
    override fun xml() {
        println("Se genera el XML de la Factura")
    }
}

// En la función main(), se crean instancias de las clases LocalSale, SaleInvoice y ForeignSale.
// Se las asigna a variables de tipo SaleWithTaxes y AbstractSale.
// Luego, se llaman a los métodos calculateTaxes(), generate() y xml() en las instancias creadas.
fun main() {
    // Creación de una instancia de LocalSale y uso de los métodos heredados
    var sale: SaleWithTaxes = LocalSale(BigDecimal(100), "Hector", BigDecimal(0.16))
    sale.calculateTaxes()
    sale.generate()

    // Asignación de una instancia de SaleInvoice a una variable de tipo SaleWithTaxes
    sale = SaleInvoice(BigDecimal(100), "HectorD", BigDecimal(0.16))
    sale.calculateTaxes()
    sale.generate()
    sale.xml()

    // Creación de una instancia de ForeignSale y uso del método heredado
    val sale2: AbstractSale = ForeignSale(BigDecimal(200), "Pepe")
    sale2.generate()

    //Finalmente, se imprime la salida correspondiente a cada llamada a los métodos, que son mensajes simples indicando qué acción se está realizando.
}

