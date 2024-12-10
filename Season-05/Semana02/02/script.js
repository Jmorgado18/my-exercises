// Generic Service Module
function Service(name) {
    let items = []; // Armazena os itens do serviço
  
    return {
      // Retorna o nome do serviço
      name: () => name,
  
      // Adiciona um novo item ao serviço
      add: (item) => {
        items.push(item);
        return item;    
      }, 
  
      // Remove um item com base em um identificador (assumindo que os itens têm uma propriedade "id")
      remove: (id) => {
        const index = items.findIndex(item => item.id === id);
        if (index !== -1) {
          return items.splice(index, 1)[0]; // Remove e retorna o item
        }
        return null; // Retorna null se não encontrar
      },
  
      // Destroi todos os itens
      destroy: () => {
        items = [];
      },
  
      // Atualiza um item com base no id
      update: (id, updatedItem) => {
        const index = items.findIndex(item => item.id === id);
        if (index !== -1) {
          items[index] = { ...items[index], ...updatedItem }; // Mescla os dados atualizados
          return items[index];
        }
        return null; // Retorna null se não encontrar
      },
  
      // Obtém um item específico com base no id
      get: (id) => items.find(item => item.id === id) || null,
  
      // Lista todos os itens
      list: () => [...items]
    };
  }
  
  // Exemplo de uso:
  const userService = Service("UserService");

  // Adicionar itens
  userService.add({ id: 1, name: "Joao" });
  userService.add({ id: 2, name: "Gonçalo" });

  console.log(userService.name());
  
  // Listar itens
  console.log(userService.list());
  
  // Obter um item específico
  console.log(userService.get(1));
  
  // Atualizar um item
  userService.update(2, { name: "Mekié" });
  console.log(userService.list());
  
  // Remover um item
  userService.remove(1);
  console.log(userService.list());
  
  // Destruir todos os itens
  userService.destroy();
  console.log(userService.list());
  