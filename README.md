# COMP_Stripe
## Opis aplikacji

COMP_Stripe jest implementacją bibliotekę kliencką obsługi faktur w systemie płatności Stripe (https://stripe.com/docs/api/invoices).
W ramch proejktu obsługiwane jest tworzenie i pobieranie faktur stąd wszelkie inne niezbędne dane do utwoerzneia faktury jak Customer, InvoiceItemLine powinny być utworzone bezpośrednio w stripe dashboard.

W projekcie dodatkowo zawarto:
- testy jednostkowe przy użyciu bibliotek JUnit oraz Mockito
- walidacja parametrów z użyciem Hibernate Validator
- obsługa logowania z użyciem SLF4J i Spring AOP
