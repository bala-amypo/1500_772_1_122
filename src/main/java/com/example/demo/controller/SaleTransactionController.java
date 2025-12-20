@RestController
@RequestMapping("/saleTransactions")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction createTransaction(@RequestBody SaleTransaction transaction) {
        return service.createTransaction(transaction);
    }

    @GetMapping
    public List<SaleTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public SaleTransaction getTransaction(@PathVariable Long id) {
        return service.getTransactionById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public SaleTransaction updateTransaction(@PathVariable Long id, @RequestBody SaleTransaction updated) {
        return service.updateTransaction(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
    }
}
