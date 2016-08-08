package Enum;


public enum EnumEvento {
    KILL        ("killed")
  , BEGIN_MATCH ("New match")
  , END_MATCH    ("ended")
  ;
    
    private final String codigo;

    private EnumEvento(final String codigo ) {
        this.codigo = codigo;
    }    

	
    public static EnumEvento getPorCodigo(String codigo) {
        if (codigo.isEmpty()) {
            return null;
        }
        
        for(EnumEvento e : EnumEvento.values()) {
            if( codigo.contains(e.getCodigo())) {
                return e ;
            }
        }
        
        return null ;
    }


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}	
}
